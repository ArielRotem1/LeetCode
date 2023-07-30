class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int lowSpeed = 0, highSpeed = 10000000;

        int result = -1;
        
        while(lowSpeed <= highSpeed){
            int mid = (highSpeed + lowSpeed) / 2;

            if(isInTime(dist, hour, mid)){
                result = mid;
                highSpeed = mid - 1;
            }
            else lowSpeed = mid + 1;
        }

        return result;
    }

    boolean isInTime(int[] dist, double hour, int speed){
        for(int i = 0; i < dist.length - 1; i++){
            hour -= Math.ceil((double)dist[i] / (double)speed);
            //the reason I need this 3 lines is because 2.01 - 1.0 is not equal 1.01 but
            //1.0099999998 which made the claculation inaccurate so that in the end instead
            //of getting 0 I got -2.1337098754514727E-16 which is -2.1337098754514727 * 10^-16
            //which is really tiny but negative number
            hour *= 100;
            hour = Math.round(hour);
            hour /= 100;
        }

        hour -= (double)dist[dist.length - 1] / (double)speed;

        return hour >= 0;
    }
}
