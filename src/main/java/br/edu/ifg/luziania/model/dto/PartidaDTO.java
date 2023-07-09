package br.edu.ifg.luziania.model.dto;

import br.edu.ifg.luziania.model.entity.Time;

import java.util.List;

public class PartidaDTO {

    private List<Time> times;

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

}
