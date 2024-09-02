package org.sigar.EffectiveJava.chapter6_ENUM.Interface;


public enum BasicOperation implements OperationInterface{
    PLUS("+", Double::sum),
    MINUS("-",(x,y) ->x-y);


    BasicOperation(String symbol,OperationInterface operation){
        this.symbol = symbol;
        this.operation = operation;
    }

    public final String symbol;
    public final OperationInterface operation;

    public static <T extends Enum<T> & OperationInterface> void test
        (Class<T> enumType,double x, double y){
        for(OperationInterface op : enumType.getEnumConstants()){
            System.out.printf("%f %s %f = %f %n",x,op,y,op.apply(x,y));
        }
    }

    @Override
    public double apply(double x, double y) {
        return operation.apply(x,y);
    }

    @Override
    public String toString(){
        return symbol;
    }

}
