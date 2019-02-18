package me.daniel.ch2;

public final class PhoneNumber {
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
}
