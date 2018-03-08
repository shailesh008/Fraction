public class Fraction {

    public int num;
    public int den;
    
    public Fraction(){
        
    }
    
    public Fraction(int n, int d){
        num = n;
        den = d;
    }
    
    public Fraction addition(Fraction f1){
        Fraction result;
        int d = lcm(den, f1.den);
        int n = (num * d / den) + (f1.num *  d / f1.den);
        
        result = new Fraction(n, d);
        return reduce(result);
    }
    
    public Fraction subtraction(Fraction f1){
        Fraction result;
        int d = lcm(den, f1.den);
        int n = (num * d / den) - (f1.num *  d / f1.den);
        
        result = new Fraction(n, d);
        return reduce(result);
    }
    
    public Fraction multiplication(Fraction f1){
        Fraction result;
        int d = den * f1.den;
        int n = num * f1.num;
        
        result = new Fraction(n,d);
        return reduce(result);
    }
    
    public Fraction division(Fraction f1){
        Fraction result;
        int n = den * f1.num;
        int d = num * f1.den;
        
        result = new Fraction(n,d);
        return reduce(result);
    }
    
    public void display(){
        System.out.println(num + "/" + den);
    }
    
    public boolean isEqual(Fraction f1){
        int d = lcm(den, f1.den);
        int n1 = num * d / den;
        int n2 = f1.num *  d / f1.den;
        
        return n1 == n2;
    }
    
    public boolean lessThan(Fraction f1){
        int d = lcm(den, f1.den);
        int n1 = num * d / den;
        int n2 = f1.num *  d / f1.den;
        
        return n1 < n2;
    }
    
    public boolean greaterThan(Fraction f1){
        int d = lcm(den, f1.den);
        int n1 = num * d / den;
        int n2 = f1.num *  d / f1.den;
        
        return n1 > n2;
    }
    
    private int gcd(int a, int b){
        int temp;
        
        while(b > 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
    private int lcm(int a, int b){
        return (a*b) / gcd(a,b);
    }
    
    private Fraction reduce(Fraction f){
        int least = gcd(f.num, f.den);
        
        if(least <= 1){
            return f;
        }
        else{
            f.num /= least;
            f.den /= least;
            reduce(f);
        }
        
        return f;
    }
    
    
    //test section - main
    public static void main(String[] args) {
        Fraction f = new Fraction(5, 8);
        Fraction g = new Fraction(7, 16);
        Fraction result;
        
        result = f.addition(g);
        result.display();
        
        result = f.subtraction(g);
        result.display();
        
        
        result = f.division(g);
        result.display();
        
        result = f.multiplication(g);
        result.display();
        
        if(f.isEqual(f)) System.out.println("equal");
        if(f.isEqual(g)) System.out.println("equal");
        
        if(g.lessThan(f)) System.out.println("less");
        if(f.lessThan(g)) System.out.println("less");
        
        if(f.greaterThan(g)) System.out.println("greater");
        if(g.greaterThan(f)) System.out.println("greater");
    }
}
