package com.sparta.generateCentres;

public class genCentres {
        public  static int generatecenter(int months){
            int center = 0;
            if(months >= 2){
                center = months/2;
            }
            return center;
    }
}
