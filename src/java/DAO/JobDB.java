package DAO;

import Models.JobApply;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobDB extends DBContext {

    public void AddJobApply(JobApply job) {
        String sql = "INSERT INTO [dbo].[AppyJob]\n"
                + "           ([AccountID]\n"
                + "           ,[Email]\n"
                + "           ,[CV]\n"
                + "           ,[status])\n"
                + "     VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, job.getIdAccount());
            stmt.setString(2, job.getEmail());
            stmt.setString(3, job.getCv());
            stmt.setInt(4, 0);
            stmt.executeQuery();
        } catch (Exception e) {
        }
    }

    public List<JobApply> getJob() {
        List<JobApply> list = new ArrayList<>();
        String sql = "select * from AppyJob where status=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JobApply j = new JobApply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(j);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean checkApply(int id) {
        boolean result = false;
        String sql = "select * from AppyJob where AccountID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
        }

        return result;
    }

    ;

    public  JobApply getJobByAccount(int idAccount) {
        JobApply j = new JobApply();
        String s=null;
        String sql = " select * from AppyJob where AccountID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAccount);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                j.setIdAccount(rs.getInt(1));
                j.setEmail(rs.getString(2));
                j.setCv(rs.getString(3));
                j.setStatus(rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return j;
    }

    public static void main(String[] args) {
        JobDB jdb = new JobDB();
        JobApply j = jdb.getJobByAccount(8);
        System.out.println(j.toString());
    }

    public void deleteApp(int idAccount) {
      String sql="DELETE FROM [dbo].[AppyJob]  WHERE AccountID= ?";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1, idAccount);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
