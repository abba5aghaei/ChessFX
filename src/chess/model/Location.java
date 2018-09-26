package chess.model;

public class Location {
	public static final Coordinate A1 = new Coordinate(50, 632);
	public static final Coordinate A2 = new Coordinate(50, 548);
	public static final Coordinate A3 = new Coordinate(50, 465);
	public static final Coordinate A4 = new Coordinate(50, 381);
	public static final Coordinate A5 = new Coordinate(50, 298);
	public static final Coordinate A6 = new Coordinate(50, 216);
	public static final Coordinate A7 = new Coordinate(50, 133);
	public static final Coordinate A8 = new Coordinate(50, 55);
	public static final Coordinate B1 = new Coordinate(133, 632);
	public static final Coordinate B2 = new Coordinate(133, 548);
	public static final Coordinate B3 = new Coordinate(133, 465);
	public static final Coordinate B4 = new Coordinate(133, 381);
	public static final Coordinate B5 = new Coordinate(133, 298);
	public static final Coordinate B6 = new Coordinate(133, 216);
	public static final Coordinate B7 = new Coordinate(133, 133);
	public static final Coordinate B8 = new Coordinate(133, 55);
	public static final Coordinate C1 = new Coordinate(216, 632);
	public static final Coordinate C2 = new Coordinate(216, 548);
	public static final Coordinate C3 = new Coordinate(216, 465);
	public static final Coordinate C4 = new Coordinate(216, 381);
	public static final Coordinate C5 = new Coordinate(216, 298);
	public static final Coordinate C6 = new Coordinate(216, 216);
	public static final Coordinate C7 = new Coordinate(216, 133);
	public static final Coordinate C8 = new Coordinate(216, 55);
	public static final Coordinate D1 = new Coordinate(298, 632);
	public static final Coordinate D2 = new Coordinate(298, 548);
	public static final Coordinate D3 = new Coordinate(298, 465);
	public static final Coordinate D4 = new Coordinate(298, 381);
	public static final Coordinate D5 = new Coordinate(298, 298);
	public static final Coordinate D6 = new Coordinate(298, 216);
	public static final Coordinate D7 = new Coordinate(298, 133);
	public static final Coordinate D8 = new Coordinate(298, 55);
	public static final Coordinate E1 = new Coordinate(381, 632);
	public static final Coordinate E2 = new Coordinate(381, 548);
	public static final Coordinate E3 = new Coordinate(381, 465);
	public static final Coordinate E4 = new Coordinate(381, 381);
	public static final Coordinate E5 = new Coordinate(381, 298);
	public static final Coordinate E6 = new Coordinate(381, 216);
	public static final Coordinate E7 = new Coordinate(381, 133);
	public static final Coordinate E8 = new Coordinate(381, 55);
	public static final Coordinate F1 = new Coordinate(465, 632);
	public static final Coordinate F2 = new Coordinate(465, 548);
	public static final Coordinate F3 = new Coordinate(465, 465);
	public static final Coordinate F4 = new Coordinate(465, 381);
	public static final Coordinate F5 = new Coordinate(465, 298);
	public static final Coordinate F6 = new Coordinate(465, 216);
	public static final Coordinate F7 = new Coordinate(465, 133);
	public static final Coordinate F8 = new Coordinate(465, 55);
	public static final Coordinate G1 = new Coordinate(548, 632);
	public static final Coordinate G2 = new Coordinate(548, 548);
	public static final Coordinate G3 = new Coordinate(548, 465);
	public static final Coordinate G4 = new Coordinate(548, 381);
	public static final Coordinate G5 = new Coordinate(548, 298);
	public static final Coordinate G6 = new Coordinate(548, 216);
	public static final Coordinate G7 = new Coordinate(548, 133);
	public static final Coordinate G8 = new Coordinate(548, 55);
	public static final Coordinate H1 = new Coordinate(632, 632);
	public static final Coordinate H2 = new Coordinate(632, 548);
	public static final Coordinate H3 = new Coordinate(632, 465);
	public static final Coordinate H4 = new Coordinate(632, 381);
	public static final Coordinate H5 = new Coordinate(632, 298);
	public static final Coordinate H6 = new Coordinate(632, 216);
	public static final Coordinate H7 = new Coordinate(632, 133);
	public static final Coordinate H8 = new Coordinate(632, 55);
	public static final Coordinate SD1 = new Coordinate(760, 430);
	public static final Coordinate SD2 = new Coordinate(810, 430);
	public static final Coordinate SD3 = new Coordinate(856, 430);
	public static final Coordinate SD4 = new Coordinate(903, 430);
	public static final Coordinate SD5 = new Coordinate(760, 508);
	public static final Coordinate SD6 = new Coordinate(810, 508);
	public static final Coordinate SD7 = new Coordinate(856, 508);
	public static final Coordinate SD8 = new Coordinate(903, 508);
	public static final Coordinate SD9 = new Coordinate(760, 588);
	public static final Coordinate SD10 = new Coordinate(810, 588);
	public static final Coordinate SD11 = new Coordinate(856, 588);
	public static final Coordinate SD12 = new Coordinate(903, 588);
	public static final Coordinate SD13 = new Coordinate(760, 670);
	public static final Coordinate SD14 = new Coordinate(810, 670);
	public static final Coordinate SD15 = new Coordinate(856, 670);
	public static final Coordinate SD16 = new Coordinate(903, 670);
	public static final Coordinate SU1 = new Coordinate(760, 100);
	public static final Coordinate SU2 = new Coordinate(810, 100);
	public static final Coordinate SU3 = new Coordinate(856, 100);
	public static final Coordinate SU4 = new Coordinate(903, 100);
	public static final Coordinate SU5 = new Coordinate(760, 178);
	public static final Coordinate SU6 = new Coordinate(810, 178);
	public static final Coordinate SU7 = new Coordinate(856, 178);
	public static final Coordinate SU8 = new Coordinate(903, 178);
	public static final Coordinate SU9 = new Coordinate(760, 258);
	public static final Coordinate SU10 = new Coordinate(810, 258);
	public static final Coordinate SU11 = new Coordinate(856, 258);
	public static final Coordinate SU12 = new Coordinate(903, 258);
	public static final Coordinate SU13 = new Coordinate(760, 340);
	public static final Coordinate SU14 = new Coordinate(810, 340);
	public static final Coordinate SU15 = new Coordinate(856, 340);
	public static final Coordinate SU16 = new Coordinate(903, 340);
	public static final Coordinate[] locations = { E8, D8, C8, F8, B8, G8, A8, H8,
													A7, B7, C7, D7, E7, F7, G7, H7,
													D1, E1, C1, F1, B1, G1, A1, H1,
													A2, B2, C2, D2, E2, F2, G2, H2,
													A6, B6, C6, D6, E6, F6, G6, H6,
													A5, B5, C5, D5, E5, F5, G5, H5,
													A4, B4, C4, D4, E4, F4, G4, H4,
													A3, B3, C3, D3, E3, F3, G3, H3 };
	
	public static final Coordinate[] stoke = { SD1, SD2,  SD3,  SD4,  SD5,  SD6,  SD7,  SD8,
												SD9, SD10, SD11, SD12, SD13, SD14, SD15, SD16,
												SU1, SU2,  SU3,  SU4,  SU5,  SU6,  SU7,  SU8,
												SU9, SU10, SU11, SU12, SU13, SU14, SU15, SU16 };
	
	public static boolean isInLocation(int x, int y, Coordinate L) {
		if(x>=L.getX() && x<=L.getX()+83)
			if(y>=L.getY() && y<=L.getY()+83)
				return true;
		return false;
	}
	public static Coordinate getLocation(int x, int y) {
		for(Coordinate l : locations)
			if(isInLocation(x,y,l))
				return l;
		return null;
	}
	public static String getLocationName(Coordinate c) {
		if(c.equals(A1))
			return "A1";
		else if(c.equals(A2))
			return "A2";
		else if(c.equals(A3))
			return "A3";
		else if(c.equals(A4))
			return "A4";
		else if(c.equals(A5))
			return "A5";
		else if(c.equals(A6))
			return "A6";
		else if(c.equals(A7))
			return "A7";
		else if(c.equals(A8))
			return "A8";
		else if(c.equals(B1))
			return "B1";
		else if(c.equals(B2))
			return "B2";
		else if(c.equals(B3))
			return "B3";
		else if(c.equals(B4))
			return "B4";
		else if(c.equals(B5))
			return "B5";
		else if(c.equals(B6))
			return "B6";
		else if(c.equals(B7))
			return "B7";
		else if(c.equals(B8))
			return "B8";
		else if(c.equals(C1))
			return "C1";
		else if(c.equals(C2))
			return "C2";
		else if(c.equals(C3))
			return "C3";
		else if(c.equals(C4))
			return "C4";
		else if(c.equals(C5))
			return "C5";
		else if(c.equals(C6))
			return "C6";
		else if(c.equals(C7))
			return "C7";
		else if(c.equals(C8))
			return "C8";
		else if(c.equals(D1))
			return "D1";
		else if(c.equals(D2))
			return "D2";
		else if(c.equals(D3))
			return "D3";
		else if(c.equals(D4))
			return "D4";
		else if(c.equals(D5))
			return "D5";
		else if(c.equals(D6))
			return "D6";
		else if(c.equals(D7))
			return "D7";
		else if(c.equals(D8))
			return "D8";
		else if(c.equals(E1))
			return "E1";
		else if(c.equals(E2))
			return "E2";
		else if(c.equals(E3))
			return "E3";
		else if(c.equals(E4))
			return "E4";
		else if(c.equals(E5))
			return "E5";
		else if(c.equals(E6))
			return "E6";
		else if(c.equals(E7))
			return "E7";
		else if(c.equals(E8))
			return "E8";
		else if(c.equals(F1))
			return "F1";
		else if(c.equals(F2))
			return "F2";
		else if(c.equals(F3))
			return "F3";
		else if(c.equals(F4))
			return "F4";
		else if(c.equals(F5))
			return "F5";
		else if(c.equals(F6))
			return "F6";
		else if(c.equals(F7))
			return "F7";
		else if(c.equals(F8))
			return "F8";
		else if(c.equals(G1))
			return "G1";
		else if(c.equals(G2))
			return "G2";
		else if(c.equals(G3))
			return "G3";
		else if(c.equals(G4))
			return "G4";
		else if(c.equals(G5))
			return "G5";
		else if(c.equals(G6))
			return "G6";
		else if(c.equals(G7))
			return "G7";
		else if(c.equals(G8))
			return "G8";
		else if(c.equals(H1))
			return "H1";
		else if(c.equals(H2))
			return "H2";
		else if(c.equals(H3))
			return "H3";
		else if(c.equals(H4))
			return "H4";
		else if(c.equals(H5))
			return "H5";
		else if(c.equals(H6))
			return "H6";
		else if(c.equals(H7))
			return "H7";
		else if(c.equals(H8))
			return "H8";
		else
			return null;
	}
	
	public static Coordinate getLocationByName(String c) {
		if(c.equals("A1"))
			return A1;
		else if(c.equals("A2"))
			return A2;
		else if(c.equals("A3"))
			return A3;
		else if(c.equals("A4"))
			return A4;
		else if(c.equals("A5"))
			return A5;
		else if(c.equals("A6"))
			return A6;
		else if(c.equals("A7"))
			return A7;
		else if(c.equals("A8"))
			return A8;
		else if(c.equals("B1"))
			return B1;
		else if(c.equals("B2"))
			return B2;
		else if(c.equals("B3"))
			return B3;
		else if(c.equals("B4"))
			return B4;
		else if(c.equals("B5"))
			return B5;
		else if(c.equals("B6"))
			return B6;
		else if(c.equals("B7"))
			return B7;
		else if(c.equals("B8"))
			return B8;
		else if(c.equals("C1"))
			return C1;
		else if(c.equals("C2"))
			return C2;
		else if(c.equals("C3"))
			return C3;
		else if(c.equals("C4"))
			return C4;
		else if(c.equals("C5"))
			return C5;
		else if(c.equals("C6"))
			return C6;
		else if(c.equals("C7"))
			return C7;
		else if(c.equals("C8"))
			return C8;
		else if(c.equals("D1"))
			return D1;
		else if(c.equals("D2"))
			return D2;
		else if(c.equals("D3"))
			return D3;
		else if(c.equals("D4"))
			return D4;
		else if(c.equals("D5"))
			return D5;
		else if(c.equals("D6"))
			return D6;
		else if(c.equals("D7"))
			return D7;
		else if(c.equals("D8"))
			return D8;
		else if(c.equals("E1"))
			return E1;
		else if(c.equals("E2"))
			return E2;
		else if(c.equals("E3"))
			return E3;
		else if(c.equals("E4"))
			return E4;
		else if(c.equals("E5"))
			return E5;
		else if(c.equals("E6"))
			return E6;
		else if(c.equals("E7"))
			return E7;
		else if(c.equals("E8"))
			return E8;
		else if(c.equals("F1"))
			return F1;
		else if(c.equals("F2"))
			return F2;
		else if(c.equals("F3"))
			return F3;
		else if(c.equals("F4"))
			return F4;
		else if(c.equals("F5"))
			return F5;
		else if(c.equals("F6"))
			return F6;
		else if(c.equals("F7"))
			return F7;
		else if(c.equals("F8"))
			return F8;
		else if(c.equals("G1"))
			return G1;
		else if(c.equals("G2"))
			return G2;
		else if(c.equals("G3"))
			return G3;
		else if(c.equals("G4"))
			return G4;
		else if(c.equals("G5"))
			return G5;
		else if(c.equals("G6"))
			return G6;
		else if(c.equals("G7"))
			return G7;
		else if(c.equals("G8"))
			return G8;
		else if(c.equals("H1"))
			return H1;
		else if(c.equals("H2"))
			return H2;
		else if(c.equals("H3"))
			return H3;
		else if(c.equals("H4"))
			return H4;
		else if(c.equals("H5"))
			return H5;
		else if(c.equals("H6"))
			return H6;
		else if(c.equals("H7"))
			return H7;
		else if(c.equals("H8"))
			return H8;
		else
			return null;
	}
	
}
