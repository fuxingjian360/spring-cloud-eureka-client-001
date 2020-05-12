package designmodel.template;

public class ComputerWorkTest {
    public static void main(String[] args) {
        AComputerWork aComputerWork = new JavaComputerWork();
        aComputerWork.optWork();

        aComputerWork = new PHPComputerWork();
        aComputerWork.optWork();
    }
}
