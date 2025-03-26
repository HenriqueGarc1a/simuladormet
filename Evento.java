public class Evento {

    private int tipo,id;
    private double tempo;

    public Evento(int tipo,double tempo,int id){

        this.tempo = tempo;
        this.tipo = tipo;
        this.id = id;

    }

    public String getTipoS(){

        if(tipo == 1){

            return "Chegada"+"("+id+")";

        }
        else if (tipo == 2){

            return "Saida"+"("+id+")";

        }
        else{

            return "-------------";

        }


    }

    public int getTipo(){

      return this.tipo;


    }

    public double getTempo(){

        return this.tempo;

    }

    public String toString(){

            return getTipoS()+" "+getTempo();

    }    
}
