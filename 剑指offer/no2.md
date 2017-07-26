# 单例模式三种线程安全的写法

1. 懒汉式

	```java
	public class Singleton1 {
		private static Singleton1 Instance=null;
		private Singleton1(){
			
		}
		
		//双重判空 减少每回都加synchronized造成的效率问题
		public static Singleton1 getInstance(){
			if(Instance==null){
				synchronized (Singleton1.class) {
					if(Instance==null){
						Instance=new Singleton1();
					}
				}
			}
			return Instance;
		}
	}
	```

2. 饿汉式

	```java
	public class Singleton {
		private static Singleton Instance=new Singleton();
		private Singleton(){
			
		}
		
		public static Singleton getInstance(){
			return Instance;
		}
	}
	```

3. 内部类实现饿汉式加载

	```java
	public class Singleton2 {
		private Singleton2(){
			
		}
		
		public static Singleton2 getInstance(){
			return MyInstance.INSTANCE;
		}
		
		static class MyInstance {
			public final static Singleton2 INSTANCE=new Singleton2();
		}
	}
	```