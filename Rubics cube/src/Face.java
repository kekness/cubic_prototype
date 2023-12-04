public class Face {
    public char[][] values ;
    int size;
    public Face (char character,int size)
    {
        this.size=size;
        values=new char[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                 values[i][j]=character;
    }
    public void show()
    {
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++)
                System.out.print(this.values[i][j]);
            System.out.println();
        }
    }
    public void showRow(int a)
    {
        for(int i=0;i<size;i++)
            System.out.print(this.values[a][i]);
    }
    public void turn(boolean left)
    {
        char[][] help = new char[size][size];
        if (left) {
            for(int i=0;i<size;i++)
                for(int j=0;j<size;j++)
                    help[i][j]=values[j][i];
            for(int i=0;i<size;i++)
                for(int j=0;j<size;j++)
                    values[i][j]=help[i][j];
        }
        else
        {
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    help[j][size - 1 - i] = values[i][j];
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    values[i][j] = help[i][j];
        }
    }
    public void swapColumn(Face face, int n)
    {
        char[]vector = new char[size];
        for(int i=0;i<size;i++) {
            vector[i] = this.values[i][n];
            this.values[i][n] = face.values[i][n];
            face.values[i][n] = vector[i];
        }
    }
    public void swapRow(Face face, int n)
    {
        char[]vector = new char[size];
        for(int i=0;i<size;i++)
        {
            vector[i]=this.values[n][i];
            this.values[n][i] = face.values[n][i];
            face.values[n][i]=vector[i];
        }
    }
}
