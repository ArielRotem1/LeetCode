class Solution(object):
    def lengthOfLongestSubstring(self, s):
        
        dictionary = {}
        max_length = 0
        i1 = 0
        i2 = 0
        
        while i2 < len(s):
            ch = str(s[i2])
            
            while dictionary.get(ch) is not None:
                ch_to_remove = s[i1]
                dictionary.pop(ch_to_remove)
                i1 += 1
                
            max_length = max(i2 - i1 + 1, max_length)
            
            dictionary[ch] = True
            i2 += 1
        
        
        return max_length
        
        
        """
        :type s: str
        :rtype: int
        """
        