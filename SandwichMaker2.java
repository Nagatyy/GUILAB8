public class SandwichMaker2 {

    public static void main(String[] args) {
        String c = "Cheese";
        String b = "Bread";

        Thread ahmedThread = new Thread(){
            @Override
            public void run(){
                synchronized (b){
                    System.out.println("Ahmed Has Locked the Bread");
                    try{
                        sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    synchronized (c){
                        System.out.println("Ahmed Has Locked the Cheese");
                    }
                }


                System.out.println("Ahmed Has Prepared the Sandwich");
            }
        };

        Thread mohamedThread = new Thread(){

            @Override
            public void run(){
                synchronized (b){
                    System.out.println("Mohamed Has Locked the Bread");
                    try{
                        sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println(e.getLocalizedMessage());
                    }

                    synchronized (c){
                        System.out.println("Mohamed Has Locked the Cheese");
                    }
                }



                System.out.println("Mohamed Has Prepared the Sandwich");
            }

        };

        ahmedThread.start();
        mohamedThread.start();

    }

}
