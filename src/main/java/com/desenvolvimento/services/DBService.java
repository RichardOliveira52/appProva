package com.desenvolvimento.services;

import com.desenvolvimento.domains.*;
import com.desenvolvimento.domains.enums.Dificuldade;
import com.desenvolvimento.domains.enums.OrdemDePrioridade;
import com.desenvolvimento.domains.enums.Status;
import com.desenvolvimento.domains.enums.StatusDeMatricula;
import com.desenvolvimento.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private OrdemDeMatriculaRepository ordemDeMatriculaRepo;

    @Autowired
    private VeiculoRepository veiculoRepo;

    public void initDB(){
        Aluno aluno01 = new Aluno(null, "Maria Cecília", "123.654.789-79", "mariaceciliamusica@gmail.com", 1695436);
        Aluno aluno02 = new Aluno(null, "Fernando da Silva", "456.321.987-55", "fernandosongs@gmail.com", 1597536 );
        Aluno aluno03 = new Aluno(null, "Milena Assunção", "147.258.369-31", "miliassbr@gmail.com", 1342598 );

        alunoRepository.save(aluno01);
        alunoRepository.save(aluno02);
        alunoRepository.save(aluno03);


        Instrutor instrutor01 = new Instrutor(null,"Wagner Pereira", "879.532.471-99", "WagnerBusiness@gmail.com", "Pós graduado");
        Instrutor instrutor02 = new Instrutor(null,"Laura Santos", "502.925.765-53", "LauraSantos@gmail.com", "Pós graduada");
        Instrutor instrutor03 = new Instrutor(null,"Selma Oliveira", "998.564.264-71", "Selmaoliveira@gmail.com", "Pós graduada");


        instrutorRepository.save(instrutor01);
        instrutorRepository.save(instrutor02);
        instrutorRepository.save(instrutor03);


        Curso curso01 = new Curso(null, "Aulas de Violão - Teoria e Prática", "https://www.youtube.com/watch?v=rovHuXdyOAY&list=PLlmPuTrdqWGoBSsfThQ-4LFbDEEpZq1tO",
                "Um curso que vai te ensinar sobre o violão e te fazer evoluir na musica", "40 horas", LocalDate.now(), "Instrumento de corda",
                aluno01, instrutor02, Dificuldade.Intermediario, Status.Em_Andamento);

        cursoRepository.save(curso01);



        Curso curso02 = new Curso(null, "Tocando Bateria do Zero", "https://www.youtube.com/watch?v=QjaQp6fdBlE&list=PLLHI4bk_qfNk-fuhwEZQ0gCtD34QmT5fG",
                "Você aprenderá desde o princípio a tocar bateria com este curso e com apoio de seu instrutor particular!",
                "180 horas", LocalDate.now(), "Instrumento de percussão",
                aluno02, instrutor01, Dificuldade.Iniciante, Status.Nao_Iniciado);

        cursoRepository.save(curso02);


        Curso curso03 = new Curso(null, "Curso de Piano - Dicas Úteis", "https://www.youtube.com/watch?v=5WZbJ8r3Om8&list=PLhT23TSR07kwCZuf4eBxk2eAORnlNliY-",
                "Você terá acesso as dicas para tocar piano com este curso e com apoio de seu instrutor particular!",
                "80 horas", LocalDate.now(), "Instrumento de teclas",
                aluno03, instrutor03, Dificuldade.Avancado, Status.Concluido);


        cursoRepository.save(curso03);

        Tecnico tec01 = new Tecnico(null, "Joice", "Bergamin", "12345678910", "joice.bergamin@gmail.com", "123");

        Usuario usuario01 = new Usuario(null, "Richard", "Oliveira", "789456123010", "richardoliveira1210@gmail.com", "123");
        Usuario usuario02 = new Usuario(null, "Marcela", "Garcez", "789456123011", "marcelagarcez@gmail.com", "123");

        OrdemDeMatricula ordem01 = new OrdemDeMatricula(null, "ordem01", "teste de matricula", OrdemDePrioridade.ALTA, StatusDeMatricula.ABERTA, tec01, usuario01);

        tecnicoRepo.save(tec01);
        usuarioRepo.save(usuario01);
        usuarioRepo.save(usuario02);
        ordemDeMatriculaRepo.save(ordem01);

        Veiculo veic01 = new Veiculo(null,"Mustang",LocalDate.now(),2200000,"Richard","52501125878");

        veiculoRepo.save(veic01);


    }
}
