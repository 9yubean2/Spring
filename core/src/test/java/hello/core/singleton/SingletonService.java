package hello.core.singleton;

public class SingletonService {
    //1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
    private static final SingletonService instance = new SingletonService();

    //2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회가능
    // 이 메서드를 호출하면 항상 같은 인스턴스를 반환
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 딱 1개의 객체 인스턴스만 존재하게 하려고 생성자를 private으로 제한
    // 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 방지
    private SingletonService(){

    }

    public void logic() {
        System.out.println("Invoke singleton object logic");
    }
}
