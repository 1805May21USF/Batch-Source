



class Input {
    public static void main(String[] args) {
    	
    	
    	
    	
    	
    	int degree = 9;
    	String Direction;
    

        if (degree <=21) {
            Direction = "North";
        } else if (degree >= 337 & degree <=359) {
        	Direction = "North";
        } else if ( degree >= 67 & degree<= 111) {
            Direction = "East";
        } else if ( degree >= 158 & degree<= 201) {
            Direction = "South";
        } else if ( degree >= 248 & degree <= 291) {
            Direction = "West";
        } else if ( degree >= 22 & degree <= 67) {
        	Direction = "NorthEast";
        } else if ( degree >= 112 & degree<= 157) {
        	Direction = "SouthEast";
        } else if ( degree >= 292 & degree<= 336) {
        	Direction = "NorthWest";
        } else if (degree >= 202 & degree <= 247) {
        	Direction = "SouthWest";
        } else if (degree >=360) {
        	Direction = "Not Found";
        } else{
            Direction = "Not found";
        }
        System.out.println("Direction is " + Direction);
    }
}