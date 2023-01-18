import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        //3.1 - Inserindo todos os funcionários na ordem da planilha.
        List<Funcionario> funcionarios = new ArrayList<>(List.of(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente")
        ));

        //3.2 - Removendo o funcionário "João" da lista.
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));


        //3.3 - Imprimir as informações de todos os funcionários.
        // OBS: não fiz a separação do salário no formato especificado
        System.out.println(funcionarios);

        //3.4 - Aplicando o bônus de 10%
        for (Funcionario f : funcionarios){
            f.bonus(new BigDecimal("0.1"));
        }

        //3.5 - Agrupando os funcionários em um map.
        Map<String, List<Funcionario>> map = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {

            if (map.get(funcionario.getFuncao()) == null){
                map.put(funcionario.getFuncao(), List.of(funcionario));
            }
            else{
                List<Funcionario> lista = new ArrayList<>(List.copyOf(map.get(funcionario.getFuncao())));
                lista.add(funcionario);
                map.replace(funcionario.getFuncao(), lista);
            }
        }

        //3.6 - Imprimindo os funcionários agrupados
        for (String k: map.keySet()) {
            System.out.println("\nFunção - " + k + ", Qtde funcionários: " + map.get(k).size());
            System.out.println(map.get(k));
        }

        //3.8 (não tem item 3.7 na lista) - Imprimir os funcionários que fazem aniversário no mês 10 e 12
        List<Funcionario> funcionariosMesDezEDoze = funcionarios.stream()
                .filter(f -> f.getDataDeNascimento().getMonth().getValue() == 10
                        || f.getDataDeNascimento().getMonth().getValue() == 12)
                .collect(Collectors.toList());
        System.out.println("\nFunionários que fazem aniversário em Outubro e Dezembro");
        System.out.println(funcionariosMesDezEDoze);

        //3.9 - Imprimindo o funcionário de maior idade.
        Collections.sort(funcionarios);
        System.out.println("\nO funcionário mais velho é: " + funcionarios.get(0).funcionarioMaisVelho());

        //3.10 - Imprimindo a lista de funcionários em ordem alfabética.
        Collections.sort(funcionarios, funcionarios.get(0));
        System.out.println("\nFuncionários em ordem alfabética.");
        System.out.println(funcionarios);

        //3.11 - Imprimindo o total de salários dos funcionários.
        BigDecimal totalSalarios = new BigDecimal("0.0");
        for(Funcionario f: funcionarios){
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        System.out.printf("\nA soma total dos salários é de R$ %.2f\n\n", totalSalarios);

        //3.12 - Imprimindo a quantidade de salários mínimos
        System.out.println("Segue a lista de quantos salários mínimos cada funcionário recebe: ");
        for(Funcionario f: funcionarios){
            BigDecimal quantidadeSalarioMinimo = f.getSalario().divide(new BigDecimal("1212.0"), RoundingMode.FLOOR);
            System.out.printf("%s recebe um total de %.2f salários mínimos.\n", f.getNome(), quantidadeSalarioMinimo);
        }
    }
}
