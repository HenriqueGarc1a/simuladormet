import java.util.ArrayList;

public class Escalonador {
    
        private ArrayList<Evento> eventos,ordenados;
        private int atual;

        public Escalonador(){

            this.eventos = new ArrayList<>();
            this.ordenados = new ArrayList<>();
            this.atual = 0;

        }

        public void add(Evento e){

             eventos.add(e);
             ordenados.add(e);
             ordenados.sort((p1,p2) -> Double.compare(p1.getTempo(), p2.getTempo()));;

        }   

        public Evento getNext(){

            atual++;

            return ordenados.get(atual-1);

        }

        public ArrayList<Evento> getEventos(){

              return eventos;

        }

        public ArrayList<Evento> getOrdenados(){

            return ordenados;

       }




}
