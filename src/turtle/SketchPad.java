package tddClass.turtle;

public class SketchPad {
    private int row;
    int[][] floor;
    private int column;
    public SketchPad(int row, int column) {
        this.row = row;
        this.column = column;
        floor = new int[row][column];
    }

    public int[][] getFloor() {
        return floor;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void display(){
        for (int[] i : floor){
            for (int j : i){
                if (j == 1){
                    System.out.print("* ");
                }else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
}
