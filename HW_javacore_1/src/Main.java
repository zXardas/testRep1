public class Main {

    public static void main(String[] args) {
        Human human = new Human("Inokentiy");
        Robo robo = new Robo("QWERTY");
        Cat cat = new Cat("shaurma");
        RunDistance[] q = {new RunDistance(),new RunDistance(), new RunDistance()};
        JumpDistance[] w = {new JumpDistance(), new JumpDistance(), new JumpDistance()};



        Movin[] team = {human,robo,cat};
  /*          for (int i=0;i<team.length;i++) { //доп. реализация
            for (int j=0;j<q.length;j++){
        team[i].run(q[j]); team[i].jump(w[j]);
        }
            if (team[i] instanceof Human){ if (((Human) team[i]).getCannMove()) System.out.println("Human easy run and jump all distance"); else
                System.out.println("Human need refreshment ");}
            if (team[i] instanceof Robo){ if (((Robo) team[i]).getCannMove()) System.out.println("Robo easy run and jump all distance"); else
                    System.out.println("Robo need refreshment ");}
            if (team[i] instanceof Cat){ if (((Cat) team[i]).getCannMove()) System.out.println("Cat easy run and jump all distance"); else
                System.out.println("Cat need refreshment ");}

}*/
            for (Movin o:team){
            for (RunDistance r:q) o.run(r);
            for (JumpDistance j:w)o.jump(j);
            if (o instanceof Human){ if (((Human) o).getCannMove()) System.out.println("Human easy run and jump all distance"); else
                System.out.println("Human need refreshment ");}
            if (o instanceof Robo){ if (((Robo) o).getCannMove()) System.out.println("Robo easy run and jump all distance"); else
                System.out.println("Robo need refreshment ");}
            if (o instanceof Cat){ if (((Cat) o).getCannMove()) System.out.println("Cat easy run and jump all distance"); else
                System.out.println("Cat need refreshment ");}
        }
    }
}


/*
Вопросы:
 1) в 1м пункте сказано что классы не должны наследоваться от одного класса (хотя было бы удобнее сделать как раз таким образом, с общими реализациями методов, без копипасты)
 поэтому пришлось объединять их в массив через интерфейс. Но в таком случае пришлось прибегать к кастнгу для проверки метода getCannMove, лбо пршлось добавлять этот метод в нтерфейс
 ,а это не отностся наверное к поведению ?
 2) Если бы у меня было бы несколько реализаций метода run, например run() и run(Rundistance r), в интерфейсе требовалось бы указыват все эти методы ?
 А если бы класс который имплементировал этот интерфейс не использовал бы все перегрузки методов? пришлось бы создавать пустые методы в реализации классов ?
 З) Как можно  объединить препятствия RunDistance[] и JumpDistance[] в 1 массив ?
 Например в Object distance = new Object (new RunDistance(),new RunDistance(), new RunDistance(),new JumpDistance(),new JumpDistance(), new JumpDistance()}
 Но потом как их применять к участникам, т.е o.run(r) или o.jump(j) не зная какой клас лежит в object ?

 */
