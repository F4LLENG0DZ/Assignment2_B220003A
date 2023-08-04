public class DiplomaData {
    public String bil;
    public String program;
    public String kursus;
    public String y2014;
    public String y2015;
    public String y2016;
    public String y2017;
    public String y2018;
    public String y2019;
    // Parameterized Constructor
    public DiplomaData(String bil,String program,String kursus,String y2014,String y2015,String y2016,String y2017,String y2018,String y2019) {
        this.bil = bil;
        this.program = program;
        this.kursus = kursus;
        this.y2014 = y2014;
        this.y2015 = y2015;
        this.y2016 = y2016;
        this.y2017 = y2017;
        this.y2018 = y2018;
        this.y2019 = y2019;
    }

    @Override
    public String toString() {
        return "Bil = "+bil+", Program = "+program+", Kursus = "+kursus+", Min = " +getMin()+", Max = "+getMax()+", Total = " +getTotal();
    }

    public int getMin()
    {
        int[] numbers = new int[]{Integer.parseInt(y2014) , Integer.parseInt(y2015) , Integer.parseInt(y2016) , Integer.parseInt(y2017) , Integer.parseInt(y2018) , Integer.parseInt(y2019)};
        int min = numbers[0]; // Initialize min with the first element

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
    public int getMax()
    {
        int[] numbers = new int[]{Integer.parseInt(y2014) , Integer.parseInt(y2015) , Integer.parseInt(y2016) , Integer.parseInt(y2017) , Integer.parseInt(y2018) , Integer.parseInt(y2019)};
        int max = numbers[0]; // Initialize min with the first element

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
    public int getTotal()
    {
        int yearTotal = Integer.parseInt(y2014) + Integer.parseInt(y2015) + Integer.parseInt(y2016) + Integer.parseInt(y2017) + Integer.parseInt(y2018) + Integer.parseInt(y2019);
        return yearTotal;
    }
}
