package designmodel.template;

public abstract class AComputerWork {
    private void openComputer() {
        System.err.println("开机");
    }

    public abstract void work();

    private void closeComputer() {
        System.err.println("关机");
    }

    public void optWork() {
        openComputer();
        work();
        closeComputer();
    }
}
