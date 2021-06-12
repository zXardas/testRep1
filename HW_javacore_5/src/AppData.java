public class AppData {
    private String[] header;
    private int[][] data ;

    public AppData(){
       header = new String[] {"Value 1","Value 2","Value 3"};
       data = new int[][] {{100,200,123},{300,400,500}};
    }

    public void getHeader(){
        for (int i=0;i<header.length;i++){
            System.out.print(header[i]+ " ");
        }
        System.out.println();
    }

    public String getHeaderForRead(){
        String headers="";
        for (int i=0;i<header.length;i++){
        if (i==header.length-1) headers+=(header[i]+"\n"); else headers+=(header[i]+";");
        }
        return headers;
    }

    public String getDataForRead(){
        String data="";
        for (int i=0; i<this.data.length;i++){
            for (int j=0;j<this.data[i].length;j++){
                if (j==this.data[i].length-1) data+=this.data[i][j];
                else data+=this.data[i][j]+";";
                }
            data+="\n";

        } return data;
    }

    public void getData(){
        for (int i=0; i<this.data.length;i++){
            for (int j=0;j<this.data[i].length;j++){
                System.out.print( this.data[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public void setHeader(String[] header){
        if (this.header.length!=header.length) {
            System.out.println("ОШИБКА, РАЗМЕРНОСТИ МАССИВА И ДАННЫХ НЕ СОВПАДАЮТ"); return;}
        for (int i=0; i<this.header.length;i++){
            this.header[i]=header[i];
        }
    }
    public void setData(String[] data, int ind){
        if (this.data[ind].length!=data.length) {
            System.out.println("ОШИБКА, РАЗМЕРНОСТИ МАССИВА И ДАННЫХ НЕ СОВПАДАЮТ"); return;}
        for (int i=0;i<this.data[ind].length;i++){
            this.data[ind][i]=Integer.parseInt(data[i]);
        }
    }
}
