package top.zjnblank.Carnation.enums;

public enum DataLevel implements ValueEnum<Integer> {
    /**
     * 无效数据
     **/
    UN_EFFECTIVE(0),

    /**
     * 有效数据
     **/
    EFFECTIVE(1);

    private final int value;

    DataLevel(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
