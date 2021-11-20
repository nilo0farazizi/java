package match;

public class Match {
private String name;
private String result;
private String TeamONE;
private Boolean bargozari;
private String TeamTWO;

    public void setBargozari(Boolean bargozari) {
        this.bargozari = bargozari;
    }

    public Boolean getBargozari() {
        return bargozari;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public String getTeamONE() {
        return TeamONE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTeamONE(String teams) {
        TeamONE = teams;
    }

    @Override
    public String toString() {
        return "Match{" +
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                ", Teams='" + TeamONE + '\'' +
                '}';
    }
}
