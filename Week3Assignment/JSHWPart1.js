var homework = {
    /**
     * Question 1
     * This function will find the fibonacci number of the value 'num'
     */
    fibonacci : function (num) {
        if(num == 0) {
            return
        } else if (num == 1) {
            return 0; 
        } else if (num == 2) {
            return 1;
        } else {
            var a = [0,1];
            var i;
            for (i = 2; i < num; i++) {
                a[i] = a[i-1] + a[i-2];
            }
            return a[num-1]; //since arrays start at 0, we subtract 1 for num'th one
        }
    },
    /**
     * Question 2
     * This function will sort an array using bubble sort
     * 
     */
    sort : function (array) {
        var newArray = array;
        var switched = false;
        if(array.length == 1) {
            return array;
        } else {
            var i;
            for(i = 0; i < array.length-1; i++) {
                if(newArray[i] > newArray[i+1]) {
                    var a = newArray[i];
                    var b = newArray[i+1];
                    newArray[i] = b;
                    newArray[i+1] = a;
                    switched = true;
                }
            }
            if(switched == true) {
                newArray = homework.sort(newArray);
            }
            return newArray;
        } 
    },
    
    /**
     * Question 3
     * This method uses recursive in order to
     * retrieve the factorial of n number
     */
    factorial : function(n) {
        if(n == 0) {
            return 1;
        }
        return n * homework.factorial(n-1);
    },

    /**
     * Question 4
     * This method will move the array left 
     * n amount of times
     */
    rotateLeft : function (array, n) {
        var i;
        var newArray = [];
        var temp;
        for(i = 0; i < array.length; i++) {
            if(array.length < n ) {
                temp = n%array.length;
            } else {
                temp = n;
            }
            if(i >= temp) {        
                //If n left is less than current location spot, the you can subtract.
                newArray[i-temp] = array[i];
            } else {  
                //With this equation, moving left past 0 will make it reach the end of the length
                newArray[(array.length-temp)+i] = array[i];
            }
        }
        return newArray;
    },
    
    /**
     * This method makes sure each bracket is closed properly
     * using recursion
     */
    balancedBrackets : function (bracketsString) {
        var str = "" + bracketsString;
        var i;
        var strToLook = []; //Symbols will be pushed and popped in here
        //var trackFound = 0;
        for(i = 0; i < str.length; i++) {
            /**
             * for Every instance of (, {, or [, we will push the opposite symbol at the end of the array
             * To close them, we need to start at the end which we will pop once they match
             * 
             * If there are no more remaining symbols in the array, it means all brackets have sucessfully closed.
             * However, if there were a closing bracket without an opening bracket, that too shall fail
             */
            switch(str.charAt(i)) {
                case "(" :
                    strToLook.push(")");
                    //console.log("Pushing \")\" \n" + strToLook + "\n");
                    break;
                case "[" :
                    //console.log("Pushing \"]\" \n" + strToLook + "\n");
                    strToLook.push("]");
                    break;
                case "{" :
                    //console.log("Pushing \"}\" \n" + strToLook + "\n");
                    strToLook.push("}");
                    break;
                case ")" :
                    if(strToLook[strToLook.length-1] == ")") {
                        //console.log("\")\" popped\n" + strToLook + "\n");
                        strToLook.pop();
                    } else {
                        return false;
                    }
                    break;
                case "]" :
                    if(strToLook[strToLook.length-1] == "]") {
                        //console.log("\"]\" popped\n" + strToLook);
                        strToLook.pop();
                    } else {
                        return false;
                    }
                    break;
                case "}" :
                    if(strToLook[strToLook.length-1] == "}") {
                        //console.log("\"}\" popped\n" + strToLook + "\n")
                        strToLook.pop();
                    } else {
                        return false;
                    }
                    break;
                
                default : 
                    break;
            }
        }
        if(strToLook.length > 0) {
            //console.log("Length is " + strToLook);
            return false;
        }
        return true;
    }
};