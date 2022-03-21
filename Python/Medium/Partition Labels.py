#Time: O(n)
#Space: O(1)
class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        
        #creating dict of the number of Occurrences of each char in the string
        #Time: O(n)
        #Space: O(26) => O(1) 
        charsOccurrencesCounter = [0] * 26
        for char in s:
            charsOccurrencesCounter[ord(char) - 97] += 1
            
        prev = 0
        first_index = 0
        second_index = 0
        curr_char = s[first_index]
        result = []
        
        #Time: O(2n) => O(n)
        #Space: O(1)
        while second_index < len(s):
            curr_char = s[second_index]
            curr_char_ord_minus_97 = ord(curr_char) - 97
            
            while charsOccurrencesCounter[curr_char_ord_minus_97] != 0:
                charsOccurrencesCounter[ord(s[first_index]) - 97] -= 1
                first_index += 1
                
            #check to find if in the part we currently check there are letters which
            # not all of them is in this part
            while second_index < first_index and charsOccurrencesCounter[ord(s[second_index]) - 97] == 0:
                second_index += 1
                
            # a part of s is found
            if second_index == first_index:
                result.append(first_index - prev)
                prev = first_index
                    
        
        return result
        
        
