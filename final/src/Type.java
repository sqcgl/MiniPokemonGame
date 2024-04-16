public enum Type {
    FIRE, WATER, GRASS, ELECTRIC, ROCK, ICE, NORMAL;
	
    public boolean isCounter(Type otherType) {
        switch (this) {
            case FIRE:
                return otherType == Type.GRASS || otherType == Type.ICE;
            case WATER:
                return otherType == Type.FIRE || otherType == Type.ROCK;
            case GRASS:
                return otherType == Type.WATER || otherType == Type.ROCK;
            case ELECTRIC:
                return otherType == Type.WATER;
            case ROCK:
                return otherType == Type.FIRE || otherType == Type.ICE;
            case ICE:
                return otherType == Type.GRASS;
            default:
                return false;
        }
    }
}
