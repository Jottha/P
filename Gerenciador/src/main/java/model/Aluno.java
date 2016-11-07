package model;

import java.util.ArrayList;


public class Aluno 
{	
	private int id_aluno;
	private String nome;
	private String matricula;
	private String periodo;
	private ArrayList<Projeto> listaDeProjetos = new ArrayList<>();
	
	
	

	public Aluno(String nome, String matricula, String periodo)
	{
		this.nome = nome;
		this.matricula = matricula;
		try
		{	if(periodo.trim().isEmpty() || periodo == null)
			{
				throw new CampoObrigatorioAlunoException();
			}
			
			int per = Integer.parseInt(periodo);
			
			if(per < 4)
			{
				throw new PeriodoInvalidoException();
			}
			
		}catch(CampoObrigatorioAlunoException|PeriodoInvalidoException e)
		{
				System.out.println(e.getMessage());
		}
	}
	
	public void inserirProjeto(Projeto projeto)
	{
		this.listaDeProjetos.add(projeto);
	}
	
	
	
	public ArrayList<Projeto> getListaDeProjetos()
	{
		return listaDeProjetos;
	}
	
	
	public void setListaDeProjetos(ArrayList<Projeto> listaDeProjetos)
	{
		this.listaDeProjetos = listaDeProjetos;
	}
	
	
	
	
	public boolean contemProjeto(Projeto projeto){
		for (Projeto proj : listaDeProjetos) {
			if(proj.equals(projeto)){
				return true;
			}
		}return false;
	}
	



	@Override
	public String toString() {
		return "\nAluno \tnome: " + nome + ", matricula: " + matricula
				+ " periodo: " + periodo ;
	}
	

}
