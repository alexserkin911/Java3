package lesson3;

import java.util.List;

public class IoHistoryServiceImplement implements HistoryService{
    @Override
    public List<String> getHistory() {
        return List.of();
    }

    @Override
    public List<String> getHistory(int limit) {
        return List.of();
    }

    @Override
    public void saveHistory(List<String> history) {

    }
}
