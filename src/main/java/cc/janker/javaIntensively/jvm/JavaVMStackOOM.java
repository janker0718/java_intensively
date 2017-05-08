package cc.janker.javaIntensively.jvm;
/**
 * VM Args：-Xss2M （这时候不妨设大些）
 * @author janker0718
 */
public class JavaVMStackOOM {
	 
    private void dontStop() {
           while (true) {
           }
    }

    public void stackLeakByThread() {
           while (true) {
                  Thread thread = new Thread(new Runnable() {
                         @Override
                         public void run() {
                                dontStop();
                         }
                  });
                  thread.start();
           }
    }

    public static void main(String[] args) throws Throwable {
           JavaVMStackOOM oom = new JavaVMStackOOM();
           oom.stackLeakByThread();
    }
}
