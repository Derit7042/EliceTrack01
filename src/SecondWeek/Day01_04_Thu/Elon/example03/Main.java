package SecondWeek.Day01_04_Thu.Elon.example03;

class Worker {
    private final String name; // 재할당할 수 없도록 final 처리
    private final String createdAt; // 재할당할 수 없도록 final 처리

    public Worker(String name, String createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public void work() {
        // 계산기를 나타내는 지역 내부 클래스, work 메서드 안에서만 유효하다. 다른 메서드에서는 접근 불가!
        class Task {
            public void run(String taskName) {
                System.out.println(taskName + " 작업 처리중!!");
            }
        }

        Task task = new Task();
        System.out.printf("작업자 %s이(가) 작업을 시작합니다.\n", name);
        task.run("부품 조립");
        System.out.printf("작업자 %s이(가) 작업을 마칩니다.\n", name);
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}


public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("박수민", "2020-01-12T00:00:00.000Z");
        worker1.work();
    }
}
