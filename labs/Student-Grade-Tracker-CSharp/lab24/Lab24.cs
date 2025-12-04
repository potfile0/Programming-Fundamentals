// See https://aka.ms/new-console-template for more information
using System;
using System.Collections.Generic;
using System.IO;

Dictionary<string, Student> students = new Dictionary<string, Student>();

try
{
    foreach (var line in File.ReadLines("studentInfo.txt"))
    {
        string[] tokens = line.Split(": ");

        string name = tokens[0];
        double score = double.Parse(tokens[1]);

        if (!students.ContainsKey(name))
        {
            students[name] = new Student(name);
        }

        students[name].AddScore(score);
    }
}
catch (IOException)
{
Console.WriteLine("Error reading input file");
}

Console.Write("Enter a name: ");
string query = Console.ReadLine();

if (students.ContainsKey(query))
{
    Console.WriteLine(students[query]);
}
else
{
    Console.WriteLine($"No information found for student \"{query}\".");
}

Student best = null;
double highestAvg = 0.0;

foreach (var st in students.Values)
{
    double avg = st.Average;     
    if (avg > highestAvg)
    {
        highestAvg = avg;
        best = st;
    }
}

Console.WriteLine();
Console.WriteLine($"Highest scoring student: {best}");
