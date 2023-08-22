package Vykintas.DTO;

import java.util.List;

public class ProfitusResponse {
    private List<Project> data;

    public ProfitusResponse() {
    }

    public List<Project> getData() {
        return data;
    }

    public void setData(List<Project> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vykintas.DTO.ProfitusResponse{" +
                "data=" + data +
                '}';
    }
}
