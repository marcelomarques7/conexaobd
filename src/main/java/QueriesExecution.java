import java.util.List;

public class QueriesExecution {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();

        // =========================== 1 - Consulta =================================================
        List<Aluno> alunos = alunoDAO.list();
        List<Curso> cursos = cursoDAO.list();

        //alunos.stream().forEach(System.out::println);
        //cursos.stream().forEach(System.out::println);



        // ======================= 1.1 - Consulta com filtro ========================================
        Aluno alunoParaConsulta = alunoDAO.getById(1);
        Curso cursoParaConsulta = cursoDAO.getById(1);

        //System.out.println(alunoParaConsulta);
        //System.out.println(cursoParaConsulta);


        // =========================== 2 - Inserção =================================================
        Aluno alunoParaInsercao = new Aluno(
                "Matheus",
                43,
                "SP"
        );

        Curso cursoParaInsercao = new Curso(
                "Eng Sofware",
                250
        );

        //alunoDAO.create(alunoParaInsercao);
        //cursoDAO.create(cursoParaInsercao);


        // =========================== 3 - Delete ===================================================
        //alunoDAO.delete(1);
        //cursoDAO.delete(1);


        // =========================== 4 - Atualizar ================================================
        Aluno alunoParaAtualizar = alunoDAO.getById(3);
        alunoParaAtualizar.setNome("Joaquim");
        alunoParaAtualizar.setIdade(18);
        alunoParaAtualizar.setEstado("RS");

        //alunoDAO.update(alunoParaAtualizar);

        Curso cursoParaAtualizar = cursoDAO.getById(3);
        cursoParaAtualizar.setNome("ADS");
        cursoParaAtualizar.setDuracao_horas(45);

        //cursoDAO.update(cursoParaAtualizar);
    }

}
