public class ExB110 {

    public static void main(String[] args) {
        String firstName="Sandy";
        Gender gender=Gender.FEMALE;
        int startAge=Integer.parseInt(args[0]);
        int age=Integer.parseInt(args[1]);
        double monthlyGrossStartSalary=Double.parseDouble(args[2]);
        boolean senior=true;

        // Salary history
        int loopAge=startAge;
        double salary=monthlyGrossStartSalary;
        double netSalary=0;

        while (loopAge<=age && loopAge<=startAge+35){

            if (loopAge!=startAge){ salary=salary*1.05;}
            double grossSalary=salary*12;
            //System.out.println("monthly gross salary is " + salary);
            //System.out.println("yearly gross salary is " + grossSalary);

            double taxRate=0;
            if (grossSalary<13870){
                taxRate=25;
            } else if (grossSalary>=13870 && grossSalary<24480){
                taxRate=40;
            } else if (grossSalary>=24480 && grossSalary<42370){
                taxRate=45;
            } else {
                taxRate=50;
            }
            //System.out.println("taxRate is " + taxRate);

             netSalary = salary*(1-taxRate/100.);

            System.out.println(firstName + "'s net salary at " + loopAge + " is " + netSalary );
            loopAge+=2;

            //System.out.println();
        }

         // pronouns based on gender
        String personalPronoun="";
        String reflexivePronoun="";
        String posessivePronoun="";

        switch(gender){
            case MALE: personalPronoun="he"; reflexivePronoun="him"; posessivePronoun="his"; break;
            case FEMALE: personalPronoun="she"; reflexivePronoun="her"; posessivePronoun="her"; break;
            case OTHER:  personalPronoun="they"; reflexivePronoun="them"; posessivePronoun="their";

        }

        String personalPronounCapitalized=personalPronoun.substring(0,1).toUpperCase() + personalPronoun.substring(1).toLowerCase();
        String posessivePronounCapitalized=posessivePronoun.substring(0,1).toUpperCase() + posessivePronoun.substring(1).toLowerCase();

        double monthlyGrossSalary=salary;

        //print basic data
        System.out.println("\n"+firstName + " is " + age + " years old. " + posessivePronounCapitalized + " monthly gross salary is " + monthlyGrossSalary + ".");
        System.out.println(personalPronounCapitalized + " is" + ((!senior)?" not":"")  + " a senior.");
        System.out.println(posessivePronounCapitalized + " net salary is " + netSalary + ".");

        //domain info
        String[] domains = {"Java","Oracle","XML","SAS"};
        System.out.println("There are " + domains.length + " domains linked with " + reflexivePronoun + ":");
        for (String domain:domains){
            System.out.println(domain);
        }


    }
}
