import java.util.ArrayList;
import java.util.Random;

public class Simulador {
    
        private Escalonador escalonador;
        private int size,fila,cmax,cmin,smax,smin,ids,maxale,ale = 0,perdidos = 0,servers;
        private double tempo;
        private Evento atual;
        private ArrayList<Double>  prob = new ArrayList<>();


        public Simulador(int size,int cmin,int cmax,int smin,int smax,double first,int maxale,int servers){

            this.size = size;
            this.fila = 0;
            this.cmin = cmin;
            this.cmax = cmax;
            this.smin = smin;
            this.smax = smax;
            this.ids = 1;
            this.escalonador = new Escalonador();
            escalonador.add(new Evento(1, first, ids));
            this.ids++;
            this.maxale = maxale;
            this.tempo = 0;
            this.servers = servers;

        }


        public void simular(){

            System.out.println(tempo+" "+fila);

            while(ale < maxale){
            atual = escalonador.getNext();


            try {

                prob.set(fila,prob.get(fila)+atual.getTempo()-tempo);
                
            } catch (Exception e) {
                prob.add(fila,atual.getTempo()-tempo);
            }

            tempo+= (atual.getTempo()-tempo);



            if(atual.getTipo() == 1){

                this.chegada();

            }
            else if(atual.getTipo() == 2){

                this.saida();

            }

            System.out.println(atual+" "+fila);

        }

        }

        public void getProb(){
       
            for(int i =0 ; i< prob.size();i++){
    
                System.out.println(i + " "+prob.get(i)+" "+(prob.get(i)/tempo)*100+"%");
    
            }

            System.out.println(tempo);
            System.out.println(perdidos);
    
    
        }


        private void chegada(){

            if(fila < size){

                fila++;

                if(fila <=servers){
                    escalonador.add(new Evento(2, this.getTempoSaida(), ids));
                    ids++;
                }

            }
            else{

                perdidos++;

            }

            escalonador.add(new Evento(1, this.getTempoChegada(), ids));
            ids++;

        }


        private void saida(){

            fila--;

            if(fila >= servers){

                escalonador.add(new Evento(2, this.getTempoSaida(), ids));
                ids++;
    
            }


        }

        private double getTempoSaida(){

            Random r = new Random();
            
            ale++;
            return tempo+r.nextDouble(smin, smax);

            

        }

        private double getTempoChegada(){

            Random r = new Random();
            ale++;
            return tempo+r.nextDouble(cmin, cmax);


        }













}
