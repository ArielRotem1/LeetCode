//Time: O(2^m * n) - n: people.size(), m: req_skills.length
//Space: O(2^m)
class Solution {

    Map<String, Integer> skillToIndex;
    int[] people;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        skillToIndex = new HashMap<>();

        for(int i = 0; i < req_skills.length; i++){
            skillToIndex.put(req_skills[i], i);
        }

        //convert people
        this.people = new int[people.size()];
        for(int i = 0; i < people.size(); i++){
            for(String skill : people.get(i)){
                this.people[i] |= 1 << skillToIndex.get(skill);
            }
        }

        //clean people
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

        long[] dp = new long[(1 << req_skills.length)];

        long result = DFS((1 << req_skills.length) - 1, dp);

        int[] smallestTeam = new int[Long.bitCount(result)];
        int smallestTeamIndex = 0;
        for(int i = 0; i <= people.size(); i++){
            if((result & (1L << i)) > 0){
                smallestTeam[smallestTeamIndex++] = i;
            }
        }

        return smallestTeam;
    }

    public long DFS(int neededSkills, long[] dp){

        if(neededSkills == 0) return 0;

        //if I saw this combination of people already then stop searching in this way
        if(dp[neededSkills] != 0){
            return dp[neededSkills];
        }

        for(int i = 0; i < people.length; i++){
            //check if the person has a skill I don't have already
            if((neededSkills & (~people[i])) != neededSkills){
                long newPeople = DFS((neededSkills & (~people[i])), dp) | (1L << i);

                if(dp[neededSkills] == 0 || Long.bitCount(newPeople) < Long.bitCount(dp[neededSkills])){
                    dp[neededSkills] = newPeople;
                }
            }
        }

        return dp[neededSkills];
    }
}
