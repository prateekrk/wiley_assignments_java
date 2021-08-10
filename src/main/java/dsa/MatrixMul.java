package DSA;

public class MatrixMul {



    public static void main(String args[]){

    }

}
class Matrix{
    private int[][] a;
    Matrix(int[][] a){
        this.a=a;
    }
    int[][] mul(int b[][]){
        int[][] c=new int[a.length][b.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;i<b.length;j++){
                c[i][j]=0;
                for(int l=0;l<a.length;l++){
                    c[i][j]+=a[i][l]*b[l][j];
                }
            }
        }
        return c;
    }
    void display(){
        for(int i=0;i<a.length;i++){
            for(int j=0;i<a.length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

}
