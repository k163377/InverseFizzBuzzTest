/**
 * Created by bntwng on 2017/05/14.
 */
public class InverseFizzBuzz {
    static final int ARRAY_LENGTH = 256;

    enum FizzBuzz{
        Fizz,
        Buzz,
        FizzBuzz;

        public static FizzBuzz dicision(int i){//入力が何か判定, 3と5の倍数以外と0の入力を考慮していない
            if(i % 5 == 0 && i % 3 == 0)return FizzBuzz;
            else if(i % 5 == 0)return Buzz;
            else if(i % 3 == 0)return Fizz;

            return Fizz;
        }
    }
    //配列中にFizzBuzzがある時, pは最低のFizzBuzzを表す
    int FizzBuzzResolve(FizzBuzz[] input, int p){
        int min = 15;
        //最初の数がどこかを当てる
        for(int i = p-1; i >= 0; i--){
            if(input[i] == FizzBuzz.Fizz){
                min -= 3;
            }
        }
        //仮に先頭がBuzzだったなら、Buzz用の処理をする
        if(input[0] == FizzBuzz.Buzz){
            if(input[2] == FizzBuzz.Fizz) min = 5;
            else min = 10;
        }
        return min;
    }
    //配列中にBuzzがあってFizzBuzzが無い時, pは最低のBuzzを表す
    int BuzzResolve(FizzBuzz[] input, int p){
        int i;//イテレータ
        int count = 0;

        if(((p-2) > -1) && input[p-2] == FizzBuzz.Fizz)return 6;
        else return 5-(p*2);
    }
    //最低の数を計算
    int lowestValueCalculation(FizzBuzz[] input){
        int minBuzzPoint = -1;//FizzBuzzが無く、Buzzがある場合に利用
        int min = -1;//最低がいくらかを記憶

        for(int i = 0;i < input.length;i++){
            //Buzz最低のBuzzの位置を記憶
            if(minBuzzPoint == -1 && input[i] == FizzBuzz.Buzz)minBuzzPoint = i;
            //FizzBuzzが入っているか判定、入っていたら最低を作成
            if(input[i] == FizzBuzz.FizzBuzz){
                min = FizzBuzzResolve(input, i);
                break;
            }
        }

        if(min == -1 && minBuzzPoint != -1) min = BuzzResolve(input, minBuzzPoint);
        else if(min == -1 && input.length == 2)min = 6;
        else if(min == -1)min = 3;

        return min;
    }
    //数列と最低限の数の設定
    int[] sequenceCreation(FizzBuzz[] input, int min)throws Exception{
        int[] sequence = new int[input.length];
        int count = 0;
        int i = min;

        while(count < input.length){
            if(i%3 == 0 || i%5 == 0){
                if(input[count] == FizzBuzz.dicision(i)){
                    sequence[count] = i;
                    count++;
                }else{
                    throw new Exception("異常なFizzBuzzの入力");
                }
            }
            i++;
        }
        return sequence;
    }

    //FizzBuzz配列の作成
    FizzBuzz[] createArray(){
        FizzBuzz[] array = new FizzBuzz[ARRAY_LENGTH];

        int num = 3;//FizzBuzzするやつ、3スタート
        int count = 0;//入った数のカウンタ
        while(count < ARRAY_LENGTH){
            if((num % 3) == 0 || (num % 5) == 0){
                array[count] = FizzBuzz.dicision(num);
                count++;
            }
            num++;
        }
        return array;
    }
}
