import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HotelReservation implements Orcamentos {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            new HotelReservation().getCheapestHotel(bf.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCheapestHotel(String bf) {

        String[] dados = bf.split("[:,]");
        TipoCliente tipoCliente = dados[0].equals("Regular") ? TipoCliente.REGULAR : TipoCliente.REWARD;
        String dia1 = recortarDia(dados[1]);
        String dia2 = recortarDia(dados[2]);
        String dia3 = recortarDia(dados[3]);
        String resultado = "";
        float totalLakewood = orcamentoLakewood(tipoCliente, dia1, dia2, dia3);
        float totalBridgewood = orcamentoBridgewood(tipoCliente, dia1, dia2, dia3);
        float totalRidgewoor = orcamentoRidgewood(tipoCliente, dia1, dia2, dia3);
        resultado = verificarMaisBaratoECustoBeneficio(totalLakewood, totalBridgewood, totalRidgewoor);
        System.out.println(resultado);
        return resultado;
    }

    public String verificarMaisBaratoECustoBeneficio(float totalLakewood, float totalBridgewood, float totalRidgewoor) {
        if (totalLakewood <= totalBridgewood && totalLakewood <= totalRidgewoor) {

            if (totalLakewood == totalBridgewood)
                return "Bridgewood";

            else if (totalLakewood == totalRidgewoor)
                return "Ridgewood";

            else return "Lakewood";

        } else if (totalBridgewood <= totalLakewood && totalBridgewood <= totalRidgewoor) {

            if (totalLakewood == totalRidgewoor)
                return "Ridgewood";

            else return "Bridgewood";

        } else
            return "Ridgewood";

    }

    public float orcamentoRidgewood(TipoCliente tipoCliente, String dia1, String dia2, String dia3) {
        if (tipoCliente.getDescricao().equals("Regular")) {
            float totalRegular = 0f;
            totalRegular += orcamentoRidgewoodRegular(dia1);
            totalRegular += orcamentoRidgewoodRegular(dia2);
            totalRegular += orcamentoRidgewoodRegular(dia3);
            return totalRegular;

        } else if (tipoCliente.getDescricao().equals("Reward")) {
            float totalRegular = 0f;
            float totalReward = 0f;

            totalRegular += orcamentoRidgewoodRegular(dia1);
            totalRegular += orcamentoRidgewoodRegular(dia2);
            totalRegular += orcamentoRidgewoodRegular(dia3);

            totalReward += orcamentoRidgewoodReward(dia1);
            totalReward += orcamentoRidgewoodReward(dia2);
            totalReward += orcamentoRidgewoodReward(dia3);

            return Math.min(totalRegular, totalReward);
        }
        return 0f;
    }

    public float orcamentoRidgewoodReward(String dia) {
        switch (dia) {
            case "mon":
            case "tues":
            case "wed":
            case "thur":
            case "fri":
                return 100f;
            case "sat":
            case "sun":
                return 40f;
            default:
                return 0;
        }
    }

    public float orcamentoRidgewoodRegular(String dia) {
        switch (dia) {
            case "mon":
            case "tues":
            case "wed":
            case "thur":
            case "fri":
                return 220f;
            case "sat":
            case "sun":
                return 150f;
            default:
                return 0;
        }
    }

    public float orcamentoBridgewood(TipoCliente tipoCliente, String dia1, String dia2, String dia3) {
        if (tipoCliente.getDescricao().equals("Regular")) {
            float totalRegular = 0f;
            totalRegular += orcamentoBridgewoodRegular(dia1);
            totalRegular += orcamentoBridgewoodRegular(dia2);
            totalRegular += orcamentoBridgewoodRegular(dia3);
            return totalRegular;

        } else if (tipoCliente.getDescricao().equals("Reward")) {
            float totalRegular = 0f;
            float totalReward = 0f;

            totalRegular += orcamentoBridgewoodRegular(dia1);
            totalRegular += orcamentoBridgewoodRegular(dia2);
            totalRegular += orcamentoBridgewoodRegular(dia3);

            totalReward += orcamentoBridgewoodReward(dia1);
            totalReward += orcamentoBridgewoodReward(dia2);
            totalReward += orcamentoBridgewoodReward(dia3);

            return Math.min(totalRegular, totalReward);
        }
        return 0f;
    }

    public float orcamentoBridgewoodRegular(String dia) {
        switch (dia) {
            case "mon":
            case "tues":
            case "wed":
            case "thur":
            case "fri":
                return 160f;
            case "sat":
            case "sun":
                return 60f;
            default:
                return 0;
        }
    }

    public float orcamentoBridgewoodReward(String dia) {
        switch (dia) {
            case "mon":
            case "tues":
            case "wed":
            case "thur":
            case "fri":
                return 110f;
            case "sat":
            case "sun":
                return 50f;
            default:
                return 0;
        }
    }

    public float orcamentoLakewood(TipoCliente tipoCliente, String dia1, String dia2, String dia3) {

        if (tipoCliente.getDescricao().equals("Regular")) {
            float totalRegular = 0f;
            totalRegular += orcamentoLakewoodRegular(dia1);
            totalRegular += orcamentoLakewoodRegular(dia2);
            totalRegular += orcamentoLakewoodRegular(dia3);
            return totalRegular;

        } else if (tipoCliente.getDescricao().equals("Reward")) {
            float totalRegular = 0f;
            float totalReward = 0f;

            totalRegular += orcamentoLakewoodRegular(dia1);
            totalRegular += orcamentoLakewoodRegular(dia2);
            totalRegular += orcamentoLakewoodRegular(dia3);

            totalReward += orcamentoLakewoodReward();
            totalReward += orcamentoLakewoodReward();
            totalReward += orcamentoLakewoodReward();

            return Math.min(totalRegular, totalReward);
        }
        return 0f;
    }

    public float orcamentoLakewoodReward() {
        return 80f;
    }

    public float orcamentoLakewoodRegular(String dia) {
        switch (dia) {
            case "mon":
            case "tues":
            case "wed":
            case "thur":
            case "fri":
                return 110f;
            case "sat":
            case "sun":
                return 90f;
            default:
                return 0;
        }
    }

    public String recortarDia(String dia) {
        return dia.trim().substring(10, 13);
    }
}
