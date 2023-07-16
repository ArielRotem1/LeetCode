class Solution {

    Map<String, Integer> skillToIndex;
    long result;
    int[] people;
    int totalNumberOfSkills;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        result = ~0;
        totalNumberOfSkills = req_skills.length;

        skillToIndex = new HashMap<>();

        for(int i = 0; i < req_skills.length; i++){
            String skill = req_skills[i];
            skillToIndex.put(skill, i);
        }

        //convert people
        this.people = new int[people.size()];
        for(int i = 0; i < people.size(); i++){
            List<String> person = people.get(i);
            int newPerson = 0;
            for(String skill : person){
                newPerson |= 1 << skillToIndex.get(skill);
            }
            this.people[i] = newPerson;
        }

        for(int i = 0; i < this.people.length; i++){
            //check if it has been discovered as a partly set
            if(this.people[i] == 0) continue;
            for(int j = i + 1; j < this.people.length; j++){
                if(this.people[j] == 0) continue;
                if((this.people[i] | this.people[j]) == this.people[i]){
                    this.people[j] = 0;
                }
                else if((this.people[i] | this.people[j]) == this.people[j]){
                    this.people[i] = 0;
                    break;
                }
            }
        }

        DFS(0, 0, totalNumberOfSkills, new HashSet<Long>());

        int[] smallestTeam = new int[Long.bitCount(result)];
        int smallestTeamIndex = 0;
        for(int i = 0; i <= 60; i++){
            if((result & ((long)1 << i)) > 0){
                smallestTeam[smallestTeamIndex] = i;
                smallestTeamIndex++;
            }
        }

        return smallestTeam;
    }

    public void DFS(long currPeople, int currSkills, int numberOfSkillsLeft, Set<Long> combinationsOfPeople){


        //if I have acquired enough people
        if(numberOfSkillsLeft == 0){
            //if it is a smaller group, then take them instead
            if(Long.bitCount(result) > Long.bitCount(currPeople)){
                result = currPeople;
            }

            return;
        }

        //if I already found a solution with fewer people in it then stop searching in this way
        if(Long.bitCount(currPeople) > Long.bitCount(result)){
            return;
        }

        //if I saw this combination of people already then stop searching in this way
        if(combinationsOfPeople.contains(currPeople)){
            return;
        }

        combinationsOfPeople.add(currPeople);

        int currNumberOfSkills = totalNumberOfSkills - numberOfSkillsLeft;

        for(int i = 0; i < people.length; i++){
            //check if the person is already in set
            if((currPeople & ((long)1 << i)) > 0) continue;

            //check if the person has a skill I don't have already
            int person = people[i];
            if(person == 0) continue;

        
            int newCurrSkills = currSkills;

            int newNumberOfSkills = Integer.bitCount((newCurrSkills | person));

            if(newNumberOfSkills - currNumberOfSkills > 0){
                newCurrSkills |= person;

                currPeople |= (long)1 << i;
                DFS(currPeople, newCurrSkills, numberOfSkillsLeft - (newNumberOfSkills - currNumberOfSkills), combinationsOfPeople);
                currPeople &= ~((long)1 << i);
            }
        }
    }
}
