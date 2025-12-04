using System;
using System.Collections.Generic;

public class Student
{
    public string Name { get; }
    private List<double> _examScores;

    public Student(string name)
    {
        Name = name;
        _examScores = new List<double>();
    }

    public void AddScore(double score)
    {
        _examScores.Add(score);
    }

    public double Average
    {
        get
        {
            if (_examScores.Count == 0)
                return 0.0;

            double sum = 0;
            foreach (double d in _examScores)
                sum += d;

            return sum / _examScores.Count;
        }
    }

    public char Grade
    {
        get
        {
            double avg = Average;
            if (avg >= 90) return 'A';
            else if (avg >= 80) return 'B';
            else if (avg >= 70) return 'C';
            else if (avg >= 60) return 'D';
            else return 'F';
        }
    }

    public override string ToString()
    {
        return $"{Name}, average: {Average:0.00}, grade: {Grade}";
    }
}
