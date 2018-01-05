/**
 * @author : Intellicon Lab. soh
 * @version 1.0
 *          <p>
 *          == Modification Information ==
 *          <p>
 *          Date			Author			Note
 *          ----------	-------------	--------------------------------
 *          2018-01-03		soh			최초 생성
 * @packgename : PACKAGE_NAME
 * @description :
 */
public class Checker {
    private static Checker one;
    private Checker() {
    }

    public static Checker getInstance() {
        if(one==null) {
            one = new Checker();
        }
        return one;
    }

//    한개의 카드만 체크, 초과했다면 얼마나 초과했는지


//    두개 이상의 카드 조합 체크, 초과 되었는지
}
