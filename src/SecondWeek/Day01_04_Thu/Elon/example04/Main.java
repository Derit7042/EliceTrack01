package SecondWeek.Day01_04_Thu.Elon.example04;

interface Task {
    void run(String taskName);
}

class Worker {
    private final String name; // 재할당할 수 없도록 final 처리
    private final String createdAt; // 재할당할 수 없도록 final 처리

    public Worker(String name, String createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public void work() {
        // 익명 내부 클래스
        // Task interface 가지고 클래스 없이 객체를 생성, work 메서드 안에서만 유효하다. 다른 메서드에서는 접근 불가!
        // 하나의 Task interface를 가지고 구현 클래스 없이 간단하게 객체를 만들 수 있다.
        // 원래는 BaseTask implements Task와 같은 형식의 구현 클래스를 만들어서 객체화해야 할테지만 간단하게 객체를 생성할 때는 익명 내부 클래스를 사용하면 편하다.
        Task task = new Task() {
            @Override
            public void run(String taskName) {
                System.out.println(taskName + " 작업 처리중!!");
            }
        };

        System.out.printf("작업자 %s이(가) 작업을 시작합니다.\n", name);
        task.run("부품 추출");
        System.out.printf("작업자 %s이(가) 작업을 마칩니다.\n", name);
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}

class T2Worker extends Worker {
    public T2Worker(String name, String createdAt) {
        super(name, createdAt);
    }

    @Override
    public void work() {
        // 익명 내부 클래스
        // Task interface 가지고 클래스 없이 객체를 생성, work 메서드 안에서만 유효하다. 다른 메서드에서는 접근 불가!
        // 하나의 Task interface를 가지고 구현 클래스 없이 간단하게 객체를 만들 수 있다.
        // 원래는 T2Task implements Task와 같은 형식의 구현 클래스를 만들어서 객체화해야 할테지만 간단하게 객체를 생성할 때는 익명 내부 클래스를 사용하면 편하다.
        Task task = new Task() {
            @Override
            public void run(String taskName) {
                System.out.println(taskName + " 작업을 수행합니다.");
                int total = 0;
                for (int i = 1; i <= 100; i++) {
                    total = total + i;
                }
                System.out.println("1-100까지의 합은 " + total + "입니다.");
            }
        };

        System.out.printf("숙련 작업자 %s이(가) 작업을 시작합니다.\n", getName());
        task.run("개수 계수");
        System.out.printf("숙련 작업자 %s이(가) 작업을 마칩니다.\n", getName());
    }
}


public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("박수민", "2020-01-12T00:00:00.000Z");
        worker1.work();

        T2Worker worker2 = new T2Worker("김민철", "2012-11-30T00:00:00.000Z");
        worker2.work();
        Runnable work = new Runnable() {
            @Override
            public void run() {
                System.out.println("병렬 작업을 시작합니다!");
                for (int i = 0; i < 1000; i ++) {
                    System.out.println("현재 숫자는 " + i + "입니다.");
                }
                System.out.println("병렬 작업이 끝났습니다!");
            }
        };
        Thread thread = new Thread(work);
        thread.start();
    }
}