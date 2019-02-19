package me.daniel.ch2;

public final class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }


//    @Override
//    인자의 타입은 `Object`를 사용해야 한다.
//    @Override 어노테이션은 Object 사용을 강제하도록 해준다.
//    public boolean equals(PhoneNumber o) {
//        // 1. 자기 자신과 같은지 확인
//        if (o == this) return true;
//        // 2. 타입이 같은 체크
//        if (!(o instanceof PhoneNumber)) return false;
//        // 3. 타입 캐스팅
//        PhoneNumber pn = (PhoneNumber)o;
//        // 4. 주요 필드 값에 대해 비교 연산 수행
//        return pn.lineNum == lineNum && pn.areaCode == areaCode && pn.prefix == prefix;
//    }

    @Override
    public boolean equals(Object o) {
        // 1. 자기 자신과 같은지 확인
        if (o == this) return true;
        // 2. 타입이 같은 체크
        if (!(o instanceof PhoneNumber)) return false;
        // 3. 타입 캐스팅
        PhoneNumber pn = (PhoneNumber)o;
        // 4. 주요 필드 값에 대해 비교 연산 수행
        return pn.lineNum == lineNum && pn.areaCode == areaCode && pn.prefix == prefix;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다.
     * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
     * XXX는 지역 코드, YYY는 Prefix, ZZZZ는 가입자 번호다.
     * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
     *
     * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
     * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
     * 전화번호의 마지막 네 문자는 "0123"이 된다.
     * @return
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
