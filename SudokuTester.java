
public class SudokuTester {

    private void setupRegion(Game game){

        //Region 1
        Game.Region new_region1 = game.new Region(1);
        Game.Cell new_cell = game.new Cell(0,0);
        new_region1.setCell(0, new_cell);
        game.sudoku.setRegion(0, new_region1);

        //Region 2
        Game.Region new_region2 = game.new Region(2);
        Game.Cell new_cell1 = game.new Cell(0,1);
        new_region2.setCell(0, new_cell1);
        Game.Cell new_cell2 = game.new Cell(0,2);
        new_region2.setCell(1, new_cell2);
        game.sudoku.setRegion(1,new_region2);

        //Region 3
        Game.Region new_region3 = game.new Region(5);
        Game.Cell cell2_0=game.new Cell(1,0);
        Game.Cell cell2_1=game.new Cell(1,1);
        Game.Cell cell2_2=game.new Cell(2,0);
        Game.Cell cell2_3=game.new Cell(2,1);
        Game.Cell cell2_4=game.new Cell(2,2);
        new_region3.setCell(0, cell2_0);
        new_region3.setCell(1, cell2_1);
        new_region3.setCell(2, cell2_2);
        new_region3.setCell(3, cell2_3);
        new_region3.setCell(4, cell2_4);
        game.sudoku.setRegion(2,new_region3);

        //Region 4
        Game.Region new_region4 = game.new Region(4);
        Game.Cell cell4_0=game.new Cell(1,2);
        Game.Cell cell4_1=game.new Cell(1,3);
        Game.Cell cell4_2=game.new Cell(0,3);
        Game.Cell cell4_3=game.new Cell(0,4);
        new_region4.setCell(0, cell4_0);
        new_region4.setCell(1, cell4_1);
        new_region4.setCell(2, cell4_2);
        new_region4.setCell(3, cell4_3);
        game.sudoku.setRegion(3,new_region4);

        //Region 5
        Game.Region new_region5 = game.new Region(3);
        Game.Cell cell5_0=game.new Cell(2,3);
        Game.Cell cell5_1=game.new Cell(2,4);
        Game.Cell cell5_2=game.new Cell(1,4);
        new_region5.setCell(0, cell5_0);
        new_region5.setCell(1, cell5_1);
        new_region5.setCell(2, cell5_2);
        game.sudoku.setRegion(4,new_region5);

    }
    private void Initial(){
        boolean passGameTest = true;

        System.out.println("---------Creating sudoku--------------\n");
        Game game = new Game();
        game.sudoku  = game.new Board(3, 5, 5);
        setupRegion(game);

        game.sudoku.setValue(2, 0, 4);
        game.sudoku.setValue(2, 4, 1);
        game.sudoku.setValue(0, 0, -1);
        game.sudoku.setValue(0, 1, -1);
        game.sudoku.setValue(0, 2, -1);
        game.sudoku.setValue(0, 3, -1);
        game.sudoku.setValue(0, 4, -1);
        game.sudoku.setValue(1, 0, -1);
        game.sudoku.setValue(1, 1, -1);
        game.sudoku.setValue(1, 2, -1);
        game.sudoku.setValue(1, 3, -1);
        game.sudoku.setValue(2, 1, -1);
        game.sudoku.setValue(2, 2, -1);
        game.sudoku.setValue(2, 3, -1);
        game.sudoku.setValue(1, 4, -1);


        Game expecting = new Game();
        expecting.sudoku = expecting.new Board(3,5,5);
        setupRegion(expecting);

        expecting.sudoku.setValue(0, 0, 1);
        expecting.sudoku.setValue(0, 1, 2);
        expecting.sudoku.setValue(0, 2, 1);
        expecting.sudoku.setValue(0, 3, 2);
        expecting.sudoku.setValue(0, 4, 1);
        expecting.sudoku.setValue(1, 0, 3);
        expecting.sudoku.setValue(1, 1, 5);
        expecting.sudoku.setValue(1, 2, 3);
        expecting.sudoku.setValue(1, 3, 4);
        expecting.sudoku.setValue(1, 4, 3);
        expecting.sudoku.setValue(2, 0, 4);
        expecting.sudoku.setValue(2, 1, 2);
        expecting.sudoku.setValue(2, 2, 1);
        expecting.sudoku.setValue(2, 3, 2);
        expecting.sudoku.setValue(2, 4, 1);

        if(! game.solver().equals(expecting.sudoku.getValues())){
            passGameTest = false;
            System.out.println("--------------- Failed --------------\n");
        }else{
            System.out.println("----------------Pass-----------------\n");
        }


        if(! passGameTest){
            System.out.println("-----------------Analyzing---------------\n");
            for(int row = 0; row < expecting.sudoku.getValues().length; row++){
                for(int col = 0; col < expecting.sudoku.getValues()[0].length; col++){
                    if(expecting.sudoku.getValue(row,col) != game.sudoku.getValue(row,col)){
                        System.out.println("Row:"+row+"\tColumn:"+col+"\n Expected value:"+
                                expecting.sudoku.getValue(row,col)+"\n Received value:"+ game.sudoku.getValue(row,col)+"\n");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SudokuTester s = new SudokuTester();
        s.Initial();

    }

}