package View;

import Controller.Controller;
import Exceptions.MyException;
import Repository.IRepository;
import Repository.ProgramRepository;
import model.Expressions.*;
import model.Statements.*;
import model.Structures.*;
import model.Types.BoolType;
import model.Types.IntType;
import model.Values.BoolValue;
import model.Values.IValue;
import model.Values.IntValue;

import java.util.Map;
import java.util.Scanner;

public class View {
    public static void main(String[] args) throws MyException {
        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))), new PrintStmt(new
                        VarExp("v"))));

        IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp(1, new ValueExp(new IntValue(2)), new
                                ArithExp(4, new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b", new ArithExp(1, new VarExp("a"), new ValueExp(new
                                        IntValue(1)))), new PrintStmt(new VarExp("b"))))));


        IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));


        MyStack<IStmt> exeStack = new MyStack<>();
        MyList<IValue> out = new MyList<>();
        MyDictionary<String, IValue> symbolTable = new MyDictionary<>();

        PrgState prgState = new PrgState(exeStack, out, symbolTable);

        IRepository repo = new ProgramRepository(prgState);

        Controller controller = new Controller(repo);

        Scanner userInput = new Scanner(System.in);

        System.out.print("Choose a program to run: ");
        int option = userInput.nextInt();

        if (option == 1) {
            exeStack.push(ex1);
        }
        else if (option == 2) {
            exeStack.push(ex2);
        }else if (option == 3) {
            exeStack.push(ex3);
        }else throw new MyException("incorrect option");


        String programOutput = controller.executeAll();
        System.out.println(programOutput);
    }
}
