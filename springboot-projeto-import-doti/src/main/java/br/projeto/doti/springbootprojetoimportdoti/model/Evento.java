package br.projeto.doti.springbootprojetoimportdoti.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="itmn_evento")
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
    private int num_seq;
    
    @Column(name="dataevt", length=10)
	private Date dataevt;

/*     @Column(name="id_alarme", length=10)
    private int id_alarme;    
    
    @Column(name="id_equip", length=10)
    private int id_equip;  */
    @OneToOne
    @JoinColumn(name="id_alarme")
    private Alarme alarme;

    @OneToOne
    @JoinColumn(name="id_equip")
    private Equipamento equipamento;
    
    public Date getDataevt() {
        return dataevt;
    }

    public void setDataevt(Date dataevt) {
        this.dataevt = dataevt;
    }

	public int getNum_seq() {
		return num_seq;
	}

	public void setNum_seq(int num_seq) {
		this.num_seq = num_seq;
	}

    public Alarme getAlarme() {
        return alarme;
    }

    public void setAlarme(Alarme alarme) {
        this.alarme = alarme;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    // public int getId_alarme() {
    //     return id_alarme;
    // }

    // public void setId_alarme(int id_alarme) {
    //     this.id_alarme = id_alarme;
    // }

    // public int getId_equip() {
    //     return id_equip;
    // }

    // public void setId_equip(int id_equip) {
    //     this.id_equip = id_equip;
    // }

 

}