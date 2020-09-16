package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        String query = "insert into board (type, product, winery, vintage, grapes, country, regions, contents, scents) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement(query, new String[] {"boardNo"});
                        ps.setString(1, board.getType());
                        ps.setString(2, board.getProduct());
                        ps.setString(3, board.getWinery());
                        ps.setString(4, board.getVintage());
                        ps.setString(4, board.getGrapes());
                        ps.setString(4, board.getCountry());
                        ps.setString(4, board.getRegions());
                        ps.setString(4, board.getContents());
                        ps.setString(4, board.getScents());
                        return ps;
                    }
                }, keyHolder);
        board.setBoardNo(keyHolder.getKey().longValue());
    }

    public List<Board> list() throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, type, product, winery, vintage, grapes, country, regions, contents, scents, reg_date " +
                        "from board where board_no > 0 order by board_no desc, reg_date desc",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setType(rs.getString("type"));
                        board.setProduct(rs.getString("product"));
                        board.setWinery(rs.getString("winery"));
                        board.setVintage(rs.getString("vintage"));
                        board.setGrapes(rs.getString("grapes"));
                        board.setCountry(rs.getString("country"));
                        board.setRegions(rs.getString("regions"));
                        board.setContents(rs.getString("contents"));
                        board.setScents(rs.getString("scents"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }
        );

        return results;
    }

    public Board read(Long boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, type, product, winery, vintage, grapes, country, regions, contents, scents, reg_date " +
                        "from board where board_no =?",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setType(rs.getString("type"));
                        board.setProduct(rs.getString("product"));
                        board.setWinery(rs.getString("winery"));
                        board.setVintage(rs.getString("vintage"));
                        board.setGrapes(rs.getString("grapes"));
                        board.setCountry(rs.getString("country"));
                        board.setRegions(rs.getString("regions"));
                        board.setContents(rs.getString("contents"));
                        board.setScents(rs.getString("scents"));
                        board.setRegDate(rs.getDate("reg_date"));

                        System.out.println("VueBoardRepository: " + board);

                        return board;
                    }
                }, boardNo
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Long boardNo) throws Exception {
        String query = "delete from board where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    public void update(Board board) throws Exception {
        String query = "update board set type = ?, product = ?, winery = ?, vintage = ?, grapes = ?, country = ?, regions = ?, contents = ?, scents = ?" +
                "where board_no = ?";
        jdbcTemplate.update(query, board.getType(), board.getProduct(), board.getWinery(), board.getVintage(),
                board.getGrapes(), board.getCountry(), board.getRegions(), board.getContents(), board.getScents());
    }
}
