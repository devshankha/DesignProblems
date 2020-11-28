package com.chess.engne.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;

public abstract class Tile {
	protected final int tileCoordinates;
	
	private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
	
	private static Map<Integer,EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer,EmptyTile> emptyTiles = new HashMap();
		for (int i=0; i < 64;i++)
			EMPTY_TILES_CACHE.put(i, new EmptyTile(i));
		
		//coud have used guava library
		//return ImmutableMap.copyOf(EMPTY_TILES)
		return Collections.unmodifiableMap(EMPTY_TILES_CACHE);
		//return EMPTY_TILES_CACHE;
	}
	
	public static Tile createTile(final int coordinates, final Piece piece) {
		return piece != null? new OccupiedTile(coordinates, piece):EMPTY_TILES.get(coordinates);
		
	}

	private Tile(int tileCoordinates) {
		super();
		this.tileCoordinates = tileCoordinates;
	}

	public abstract boolean isOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

		private EmptyTile(int tileCoordinates) {
			super(tileCoordinates);
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean isOccupied() {			
			return false;
		}

		@Override
		public Piece getPiece() {		
			return null;
		}

	}

	public static final class OccupiedTile extends Tile {

		private final Piece pieceOnTile;

		private OccupiedTile(int tileCoordinates, Piece pieceOnTile) {
			super(tileCoordinates);
			this.pieceOnTile = pieceOnTile;
		}

		@Override
		public boolean isOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {

			return this.pieceOnTile;
		}

	}

}
