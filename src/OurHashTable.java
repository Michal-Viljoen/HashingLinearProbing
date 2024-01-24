public class OurHashTable {
    private final int BLANK = -999; //sentinel value
    private int[] data;
    private int n;

    public OurHashTable(){
        data = new int[5];          //assign size
        for (int i=0; i<data.length; i++){
            data[i] = BLANK;        //nothing in hashtable
        }
        n=0;
    }

    public int hash(int k){
        return k%5;                 //possible outputs: 0-4
    }

    public int linearProbe(int index){
        int i = index;
        while(data[i] !=BLANK){
            i++;
        }
        return i;
    }

    public int quadraticProbe(int index){
        int i=1;
        while (data[index] !=BLANK){
            index = (index+i*i)%5;
            i++;

        }
        return index;

    }public int hashPrime(int k){
        return 3-k%3;
    }
    public int doubleHash(int value){
        return hash(value)+ hashPrime(value);
    }
    public void rehash(){
        ;
    }

    public void insert(int value){
        double loadFactor = n/data.length;
        if(loadFactor>0.8){
            rehash();
        }
        int index = hash(value);
        if (data[index] == BLANK){  //no collision
            data[index] = value;
        } else {                    //there is a collision
            index = doubleHash(value);
            data[index] = value;
        }
        n++;
    }

    public void display(){
        for (int i=0; i< data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

}