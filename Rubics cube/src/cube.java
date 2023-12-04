public class cube {
    Face [][]faces = new Face[3][4];
    Face f1,f2,f3,f4,f5,f6;
    Face empty;
    int size;
    public cube(int size){
         empty = new Face(' ',size);
         this.size=size;
        generatefaces();
    }
    private void generatefaces(){
        f1 = new Face('x',size);
        f2 = new Face('y',size);
        f3 = new Face('a',size);
        f4 = new Face('b',size);
        f5 = new Face('c',size);
        f6 = new Face('d',size);
        faces[0][0]=empty;
        faces[0][2]=empty;
        faces[2][0]=empty;
        faces[2][2]=empty;
        faces[0][3]=empty;
        faces[2][3]=empty;
        faces[1][1]=f1;
        faces[1][3]=f2;
        faces[1][0]=f3;
        faces[2][1]=f4;
        faces[1][2]=f5;
        faces[0][1]=f6;
    }
    public void show() {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<size;j++)
            {
                for(int k=0;k<3;k++)
                faces[k][i].showRow(j);
                System.out.println();
            }
        }

    }
    public void move(int n)
    {
        if(n==0)
            faces[0][1].turn(true);
        if(n==size-1)
            faces[2][1].turn(false);
        if(n>=0&&n<size)
        changeST1(n);
        if(n==size)
            faces[1][0].turn(true);
        if(n==2*size-1)
            faces[1][2].turn(false);
        if(n>=size&&n<2*size)
            changeST2(n%size);
    }
    public void changeST1(int n)
    {
        for(int i=3;i>0;i--)
        faces[1][3].swapColumn(faces[1][i-1],n);
    }
    public void changeST2(int n)
    {
        faces[0][1].swapRow(faces[1][1],n);
        faces[0][1].swapRow(faces[2][1],n);
        faces[1][3].turn(true);
        faces[1][3].turn(true);
        faces[0][1].swapRow(faces[1][3],n);
        faces[1][3].turn(true);
        faces[1][3].turn(true);
    }
}
